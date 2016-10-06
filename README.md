# AndroidAsync Autobahn WebSocket Tests

This is a simple WebSocket echo server, to be run against the Autobahn tests.

Some notes:

* I'm probably doing a bunch wrong with the echo server. Some of the failures are probably my fault.

* The wstest configuration currently skips the entirety of test suite 9 ("Limits/Performance"). A large number of these tests flat-out hung the test suite, so they're being skipped for now.

* If you watch the Android log monitor while the test suite is running, a large number of Java errors are generated.

## Setting up

1. You should have a functioning Android environment (I used Android Studio 2.2 on OS X)

2. Install the Autobahn test tools: http://autobahn.ws/testsuite/installation.html#installation


## Running the tests

1. Run the project in a local emulator

2. Forward ports appropriately: `adb forward tcp:9001 tcp:20000`

3. Go into the `wstest` folder in this repo, and run the fuzzing tests: `wstest -m fuzzingclient`


## Seeing the results

Open `wstest/results/index.html`. If you don't want to run them manually, my results are included.