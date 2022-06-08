# Caro
[![Scala CI](https://github.com/TheYingThing/CaroInScala_SOFTAR/actions/workflows/scala.yml/badge.svg?branch=master)](https://github.com/TheYingThing/CaroInScala_SOFTAR/actions/workflows/scala.yml)
[![Coverage Status](https://coveralls.io/repos/github/TheYingThing/CaroInScala_SOFTAR/badge.svg?branch=master)](https://coveralls.io/github/TheYingThing/CaroInScala_SOFTAR?branch=master)

## Description

Caro is a multiplayer strategy board game. This implementation allows for two players. For rules see below.

## Configuration

The environment variable `UI_CONFIG` needs to be set to value `tui` for TUI support only 
or `gui` for both GUI and TUI support. 

## Rules

The following rules are applied:
- Same color tiles may not be placed next to each other
- No more than three tiles of the same color may be placed diagonally
- No more than two neighboring tiles may be of the same color
- Placed tiles may not exceed 6x6 in dimensions

The following tile combinations yield the following points:

![](src/main/scala/caro/resources/redButton)![](src/main/scala/caro/resources/blackButton)
: &nbsp;&nbsp; **10 points**

![](src/main/scala/caro/resources/redButton)![](src/main/scala/caro/resources/greyButton)
: &nbsp;&nbsp; **8 points**

![](src/main/scala/caro/resources/redButton)![](src/main/scala/caro/resources/whiteButton)
: &nbsp;&nbsp; **6 points**

![](src/main/scala/caro/resources/blackButton)![](src/main/scala/caro/resources/greyButton)
: &nbsp;&nbsp; **4 points**

![](src/main/scala/caro/resources/blackButton)![](src/main/scala/caro/resources/whiteButton)
: &nbsp;&nbsp; **2 points**

![](src/main/scala/caro/resources/greyButton)![](src/main/scala/caro/resources/whiteButton)
: &nbsp;&nbsp; **1 points**

**10 points** will be granted when placing the first tile

**10 points** will be subtracted upon breaking a rule

**Double points** will be granted when placing the last tile of a color
