#RxActions

RxActions is a library to smooth RxJava usage by combining actions.

##Rationale

Sometimes you have to describe side effects in your Observable chain, by means of doOnNext, doOnError, or even in the subscription. Writing several of those operators may incur on minimal performance operations, and make it a bit less readable. RxActions allows you to combine those actions sequentially.

##Usage

RxActions comes as lazily evaluated ActionN and its main use case is for doOnNext, doOnError, and subscribe operators. Please note subscribe comes in several flavours that accept ActionN for better composability.

Log correct server response and display on UI:

    getApi().requestListFromServer()
            .subscribe(RxActions.act(logElement(), getUi.displayElements()));
            
Log an error to console, then display UI message:

    getApi().requestListFromServer()
            .subscribe(/* ... */),
            RxActions.act(logError(), getUi().displayErrorMessage()));
                
Log error before and display a message before applying an error correction operator

    getApi().storeInDatabase()
            .doOnError(RxActions.act(logError(), getUi().displayErrorMessage()))
            .onErrorReturn(Collections.emptyList())
            .subscribe(/* ... */);

##Distribution

Add as a dependency to your `build.gradle`

    repositories {
        ...
        maven { url "https://jitpack.io" }
        ...
    }
    
    dependencies {
        ...
        compile 'com.github.pakoito:RxActions:1.0.+'
        ...
    }

or to your `pom.xml`

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    
    <dependency>
        <groupId>com.github.pakoito</groupId>
        <artifactId>RxActions</artifactId>
        <version>1.0.0</version>
    </dependency>

##License

Copyright (c) pakoito 2015

The Apache Software License, Version 2.0

See LICENSE.md