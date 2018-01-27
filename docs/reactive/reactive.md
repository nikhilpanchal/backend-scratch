# Reactive 

Reactive, Reactive Programming and Reactive systems are born out of a project created a Microsoft called Reactive Extensions

## Reactive Extensions (Rx)
The Reactive Extensions library used for writing asynchronous, event based programs/systems using observable sequences.

It is a method of writing systems by viewing inputs as Data Sequences: These can be a stream of data from a file or web service, web service requests, a series of mouse clicks by a user and so on.
Reactive Extensions represents these data sequences as `observable sequences` that an application can `subscribe` to in order to receive asynchronous notifications as new data arrive.

## Push Vs Pull
Reactive systems handle inputs in push mode as opposed to pull mode. 

### Pull
The pull model is very much like the `Iterator` pattern where the application as for new input whenever it is ready (`next()`)and can check if there's more input to be handled (`hasNext()`). 
In this model the application is said to be `pulling` data from the source and in most cases the data pulled is handled synchronously

Examples of this model are the way you handle result sets from a jdbc call, where you iterate over the results by mapping them using synchronous resultset mappers. 
A real world example is the case of a library where you checkout a book, read it (synchronously), and ask for the next book when you are done reading the current one.

### Push
The push model is where the data is pushed to the application from the source as `events`. The application is subscribing to a data stream (called Observable sequence) and any update (new data) is handed to it from the source. This is much like the `Observer` pattern, where the client application has handlers registered to an `Observable` that are notified whenever there is new data.
This is similar to a magazine subscription where the next issue is pushed to the subscriber regardless of whether you were done readying the previous issue.

In the `Rx` world, the Observer pattern is amended by providing two more operations or channels to the subscriber (in addition to the data).

 1. Data: Whenever new data is available it is pushed to the subscriber using the Data Channel.
 1. Completion: The subscriber is notified of `completion`: There is no more data that will be pushed to the subscriber.
 1. Error: The subscriber is notified of an `error` using this channel. This is where a subscriber can register an error handling function.

 
## Reactive Programming
Reactive programming is a subset of asynchronous programming where the availability of new information drives the logic forward rather than having control flow driven by a thread of execution.

It supports decomposing a problem into multiple *discrete* steps, where each step is executed in an asynchronous and non-blocking way, and then composed to produce a workflow.

Addresses the issue of `dataflow management through asynchronous and nonblocking execution`, usually within a single node or jvm. Once there are multiple nodes there is need to start thinking about system architecture --- reactive systems.
Reactive Programming could be a tool used to build Reactive systems.

## Reactive Systems
Reactive systems is a set of architectural design principles for building modern systems that meet the demands of scalability.

The foundation of a reactive system is `message passing` which creates a boundary between components allowing them to be decoupled in *time* (allowing for concurrency and asynchrony) and *space* (allowing for mobility and distribution)

Reactive systems need to be `responsive` -- under normal circumstances, as well as under load (`elastic`) and under failure (`resilient`).  The key to achieving this is to make systems de-coupled using `message-passing`.

 
## Reactive Streams
Reactive Streams is a programming concept for handling asynchronous data streams in a non-blocking manner while providing backpressure to stream publishers.  
 
## Resources
[Reactive Programming vs Reactive Systems](https://www.oreilly.com/ideas/reactive-programming-vs-reactive-systems)
