# publish maven projects to jcenter bintray [![Build Status](https://travis-ci.org/daggerok/publish-maven-project-to-jcenter.svg?branch=master)](https://travis-ci.org/daggerok/publish-maven-project-to-jcenter)

## build

```shell script
./mvnw
```

## run

```shell script
java -jar app/target/*-all.jar
```

# publish project artifacts as maven repository to local filesystem

```shell script
./mvnw -P publish-locally
```

## maven-release-plugin (locally)

```shell script
./mvnw release:clean release:prepare release:perform \
        -Darguments="-DskipTests -Dmaven.deploy.skip=true -Pmaven-release-locally,publish-locally" \
        -Pmaven-release-locally,publish-locally -s ./settings.xml \
        -DgenerateBackupPoms=false \
        -Dresume=false \
        -DdryRun=false \
        -DskipTests \
        --batch-mode
#if something goes wrong:
#./mvnw release:rollback -s ./settings.xml
```

## publish project artifacts as maven repository to github

```shell script
./mvnw clean
./mvnw -P publish-locally
# create manually on your github repository branch: maven
./mvnw -P publish-to-github -pl :publish-maven-project-to-jcenter -s settings.xml
```

## upload github release

* prepare [settings.xml](settings.xml) file:
  ```shell script
  cp -Rf settings.template.xml settings.xml
  ```
* update it accordingly: //servers/server/github
* run commands:
  ```shell script
  ./mvnw clean package
  ./mvnw -P upload-github-release -pl :publish-maven-project-to-jcenter -s settings.xml
  ```


## publish project artifacts to bintray jcenter maven repository

_by using maven-release-plugin_

* update [settings.xml](./settings.xml) file accordingly //servers/server/bintray-daggerok-repo
  username => bintray API key
* first time open https://bintray.com/daggerok/daggerok and create new package, ie: publish-maven-project-to-jcenter
* once repository was created, prepare / perform release using maven-release-plugin
  ```shell script
  ./mvnw release:clean release:prepare release:perform \
          -DgenerateBackupPoms=false \
          -Darguments="-DskipTests" \
          -Pmaven-release-jcenter \
          -s ./settings.xml \
          -Dresume=false \
          -DdryRun=false \
          -DskipTests \
          --batch-mode
  #if something goes wrong:
  #./mvnw release:rollback -s ./settings.xml
  ```

_links_

* [fix IDEA ${maven.multiModuleProjectDirectory} problem](https://stackoverflow.com/questions/29983683/dmaven-multimoduleprojectdirectory-not-set-issue-with-maven-and-intellij)
* [maven-release-plugin](https://maven.apache.org/maven-release/maven-release-plugin/examples/update-versions.html)
