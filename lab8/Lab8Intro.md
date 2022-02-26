% Lab 8 🚌
% CS2030S
% TBD March 2022

# Last Lab! 😃

## Your Todos
- Replace the **synchronous** methods with their **asynchronous** versions!
	- `BusAPI::getBusStopsServedBy` 
		- now returns a `CompletableFuture<String>`
	- `BusAPI::getBusServicesAt` 
		- now returns a `CompletableFuture<String>`
	- `BusStop::getBusServices` 
		- now returns a `CompletableFuture<Set<BusService>>`

## Your Todos
- Replace the **synchronous** methods with their **asynchronous** versions!
	- `BusService::getBusStops` 
		- now returns a `CompletableFuture<Set<BusStop>>`
	- `BusService::findStopsWith` 
		- now returns a `CompletableFuture<Set<BusStop>>`
	- `BusRoutes` 
		- now stores a `CompletableFuture<Set<BusStop>>` instead.

## Your Todos
- Replace the **synchronous** methods with their **asynchronous** versions!
	- `BusRoutes::description` 
		- now returns a `CompletableFuture<String>` (hint: use `thenCombine`)
	- `BusSg::findBusServicesBetween` 
		- now returns a `CompletableFuture<BusRoutes>`

## Relevant JavaDocs
- [CompletionStage](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletionStage.html) 
- [CompletableFuture](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html)

# Good luck!