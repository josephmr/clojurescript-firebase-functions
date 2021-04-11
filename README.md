# Firebase Functions in ClojureScript

This repository is an example setup of how to use ClojureScript to write Firebase functions.

## Build `functions/index.js`

```
npx shadow-cljs compile :fn
```

The `functions/index.js` file that Firebase expects to contain our function definitions is
built by shadow-cljs which is configured in `shadow-cljs.edn`. Shadow overwrites the file
with the output of the compilation of our ClojureScript. In `src/main/functions/fn.cljs`
we define the available Firebase functions and export them via `functions.fn/exports`.

## Run Locally

The Firebase emulator can be used to run functions and test locally. Follow the Firebase
documentation to install the emulator and firebase-tools, then:

```
# start shadow-cljs watch
npx shadow-cljs watch :fn

# start firebase emulator
firebase emulators:start
```

## Dependencies

Firebase function dependencies should be configured in `functions/package.json`. Shadow
is configured to look for dependencies in `functions/node_modules` for the `:fn` build
so there is no need to duplicate dependencies for Firebase functions in `package.json`.
