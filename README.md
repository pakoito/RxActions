#RxActions

RxActions is a library to smooth RxJava usage by functionally composing actions.

For the RxJava 2.X version please go to [RxConsumers](https://github.com/pakoito/RxConsumers).

##Rationale

Sometimes you have to describe side effects in your Observable chain, by means of doOnNext, doOnError, or even in the subscription. Writing several of those operators may incur on minimal performance penalties, and make the chain more verbose. RxActions allows you to combine those actions sequentially.

One acknowledged critique is that the composition can be done inlined and imperatively instead by using a lambda. That's not available on Java 1.6 versions without 3rd party tools, making it effectively more verbose.

##Usage

RxActions comes as lazily evaluated ActionN and its main use case is for doOnNext, doOnError, and subscribe operators. Please note subscribe comes in several flavours that accept ActionN for better composability.

Log correct server response, cache it, and display on UI:

    getApi().requestListFromServer()
            .subscribe(RxActions.act(logElement(), cacheElements(), getUi.displayElements()));
            
Log an error to console, then display UI message:

    getApi().requestListFromServer()
            .subscribe(/* ... */,
                       RxActions.act(logError(), getUi().displayErrorMessage()));
                
Log error, clear cache, and display a message before applying an error correction operator:

    getApi().storeInDatabase()
            .doOnError(RxActions.act(logError(), getUi().displayErrorMessage(), clearCache()))
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
