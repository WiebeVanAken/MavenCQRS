#MavenCQRS by Wiebe van Aken
An implementation of the CQRS pattern made by Wiebe van Aken, a student at the HAN University of Applied sciences.

CQRS is a pattern by Martin Fowler to segregate queries and commands in the context of software.
See <href a="https://martinfowler.com/bliki/CQRS.html">CQRS by Martin Fowler</a>

## Usage
MavenCQRS requires JDK17, and is not available through the Maven Central Repository.

```xml
<dependency>
  <groupId>personal.wiebe</groupId>
  <artifactId>cqrs</artifactId>
  <version>1.1</version>
</dependency> 
```

## Dependencies
This package uses the Jakarta EE CDI Dependency Container, it's not designed to work without Jakarta EE CDI.