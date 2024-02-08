# Architecture test

## Business requirements

1. User can place order for pizza.
2. After order is paid, pizza can be baked.
3. After pizza is baked, it can be sent to the user.
4. User can eat pizza (but we don't control that with this app, they also may give it to a dog).

## Architecture requirements

1. Split to modules.
2. Modules expose methods that can be **really** used from other modules, while **does not expose** methods that should not be used externally (hecagonal architecture paradigm).      
3. Everything is single-threaded, we don't work on multithreading problems here.

### Some architecture refs

1. Standard and classic *clean* service architecture (Spring).
2. Hexagonal architecture.
3. Domain driven development (DDD).

(this project supposed to be a mixin of all best practices from all mentioned above)

## Some final thoughts

1. Entities can be exposed from modules, but they should not contain any setters or updatable methods, because it would suggest (code) user that they can use them, while they not, and they should use an appropriate service methods.
2. Entities can contain some "domain logic" and it's OK (DDD) until this logic is package protected and can't be used freely outside a module (eg. `Oven.startBaking()`).
3. Modules expose only public part of service(s) interface which is supposed to be used externally (hexagonal/port, eg: `OvenService.bake(Pizza)`), and the rest is hidden and internal (eg: `OvenService.bake(Oven, Pizza)`).
4. Modules can contain more internal modules which we can be hidden with package-visible classes (eg: `BakingService`)
5. As a result
   - External (code) user of a module can only call appropriate methods and shouldn't make any mistakes.
   - DDD can do the pure domain-logic work.
