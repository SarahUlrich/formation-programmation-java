#!/bin/bash

asciidoctor -T asciidoctor-reveal.js/templates/slim cours-javaee.ad
asciidoctor exercices-javaee.ad

asciidoctor cours-java.ad
asciidoctor exercices-java.ad