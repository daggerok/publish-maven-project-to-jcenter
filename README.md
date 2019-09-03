# publish maven projects to jcenter bintray

_build_

```shell script
./mvnw
```

_run_

```shell script
java -jar app/target/*-all.jar
```

_publish project artifacts as maven repository to local filesystem_

```shell script
./mvnw -P publish-locally
```

_publish project artifacts as maven repository to github_

```shell script
./mvnw -P publish-locally
./mvnw -P publish-to-github
```

_create github release_

<!--

_publish project artifacts to bintray jcenter maven repository_

* update [settings.xml](./settings.xml) file accordingly to username => bintray API key
* prepare / perform release
* checkout manually to created tag and/or trigger via CI job automatically project tag artifacts publishing to jcenter bintray maven repository:

-->
