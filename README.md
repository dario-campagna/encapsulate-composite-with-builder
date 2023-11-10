# Refactoring to Patterns – Encapsulate Composite with Builder

*Encapsulate Composite with Builder* is the refactoring described in Chapter 6 of the book [Refactoring to Patterns](https://industriallogic.com/xp/refactoring/).

The commits in this repository try to mimic the test-driven steps described in the example section of the chapter. The first commit represents the initial state with the Composite ```TagNode```.

We report below the mechanics of this refactoring.

### Mechanics

The following mechanics assume you already have Composite-construction code and you'd like to encapsulate this code with a Builder. 

1. Create a *builder*, a new class that will become a Builder (see [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns)) by the end of this refactoring. Make it possible for your builder to produce a one-node Composite. Add a method to the builder to obtain the result of its build.

    ✅ Compile and test.

2. Make the builder capable of building children. This often involves creating multiple methods for allowing clients to easily direct the creation and positioning of children.

    ✅ Compile and test.

3. If the Composite-construction code you're replacing sets attributes or values on nodes, make the builder capable of settings those attributes and values.

    ✅ Compile and test.

4. Reflect on how simple your builder is for client to use, and then make it simpler.

    ✅ Compile and test.

5. Refactor your Composite-construction code to use the new builder. This involves making your client code what is knows in [Design Patterns](https://en.wikipedia.org/wiki/Design_Patterns) as a Builder:Client and Builder:Director.

   ✅ Compile and test.