# the idiotic calculator

![Java CI with Maven](https://github.com/erniehs/idiotic-calc/workflows/Java%20CI%20with%20Maven/badge.svg)

truly the silliest implementation of a calculator. however we must learn these modern microservice ways so we may as well do something silly... _i would not reccomend this as a model for writing a calculator :)_

## prerequisites

- maven
- docker and kubernetes (running)
- jvm
- some IDE (i use vscode and ll the random plugins)

## spin up the k8s dashboard

see ./k8s/dashboard.cmd

```sh
kubectl apply -f https://raw.githubusercontent.com/kubernetes/dashboard/v2.0.0/aio/deploy/recommended.yaml

kubectl proxy
```

in another terminal grab the secret key to allow you to login to the dashboard for k8s

```sh
kubectl -n kubernetes-dashboard get secret $(kubectl -n kubernetes-dashboard get sa/kubernetes-dashboard -o jsonpath="{.secrets[0].name}") -o go-template="{{.data.token | base64decode}}"
```

you can use the auth key for the login to the [dashboard](http://localhost:8001/api/v1/namespaces/kubernetes-dashboard/services/https:kubernetes-dashboard:/proxy/)

## setup/deploy the idiotic-calc app

```sh
mvn clean install from root
```

spin up a local registry for images (or perhaps you have another one..)

```sh
docker run -d -p 5000:5000 registry
```

build the images, from root will do all

```sh
mvn spring-boot:build-image
```

push the images to the registry (can do this in pom also if u have docker etc.)

```sh
docker push localhost:5000/library/op:latest
docker push localhost:5000/library/calculator:latest
```

you should see your images in the local registry [here](http://localhost:5000/v2/_catalog)

run kustomize and pipe the results to kubernetes spinning up the stack

```sh
cd k8s\kustomize
.\kustomize.exe build . | kubectl apply -f -
```

or, windows

```cmd
cd k8s\kustomize
.\kustomize.exe build . | kubectl apply -f -
```

this creates a calculator namespace in k8s with all the stuff.

if you are playing with the code, 

```sh
kubectl -n calculator rollout restart deploy
```

will redeploy everything as we have imagePullPolicy: Always and the :latest version in the images etc.  clearly more adept devops will change this.
you can also look at using [skaffold](https://skaffold.dev/docs/install/) for instant gratification

## playing with the deployment/application

you have explosed endpoints,

http://localhost/calc/12+5

http://localhost:81/12/add/14

http://localhost:81/12/sub/14

http://localhost:81/12/mul/14

http://localhost:81/12/div/14

### jmeter, hammer the calculator

jmeter file in jmeter folder

## horizontal auto scaling

enable the metrics server on docker desktop k8s

```sh
cd k8s\metrics-server
kubectl create -f .\components.yaml
```

checkout the status of your pods (also use dashboard)

```sh
kubectl top pods --namespace=calculator
```

## shutdown

I go to the dashboard and delete the namespace _calculator_ and it all goes, quite easy...

or delete from the command line with

```sh
kubectl delete namespace calculator
```

## summary

the wonders of cut-and-paste development allow us to experiment with these microserve technlogies on our laptop; _which is nice..._

## appendix

i put all this together from the following sources,

https://docs.docker.com/docker-for-windows/install/

https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/

the rather splendid https://hackmd.io/@ryanjbaxter/spring-on-k8s-workshop

https://spring.io/blog/2020/01/27/creating-docker-images-with-spring-boot-2-3-0-m1

https://spring.io/guides/tutorials/rest/

https://spring.io/guides/gs/multi-module/

https://blog.codewithdan.com/enabling-metrics-server-for-kubernetes-on-docker-desktop/

https://kubernetes.io/docs/tasks/configure-pod-container/

and, or course, [stackoverflow](https://stackoverflow.com/)
