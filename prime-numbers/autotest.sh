#!/bin/bash

while true; do (clear; date; cake midje) 2>&1 | tail -1000; sleep 1; done
