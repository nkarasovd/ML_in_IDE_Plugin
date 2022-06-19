# ML_in_IDE_Plugin

![Build](https://github.com/nkarasovd/ML_in_IDE_Plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Plugin example

Below is an example of how the plugin works
using a [`SimpleModel`](src/main/java/org/intellij/sdk/model/impl/SimpleModel.java) 
that offers five default candidates.

<p align="center">
 <img src="./images/plugin_example.gif" alt="Drawing", width=75%, height="100%">
</p>

When running the plugin using the [`FastTextModel`](src/main/java/org/intellij/sdk/model/impl/FastTextModel.java), 
an error occurs that I have not been able to fix at the moment. 
Below is a screenshot that shows that I was able to load 
the pretrained `FastTextModel` into the Java project.

<p align="center">
 <img src="./images/fasttext_java.png" alt="Drawing", width=75%, height="100%">
</p>

## Pretrained FastText model

Locate pretrained `FastText` model in this [folder](src/main/resources/model).
You can download `.vec` file [here](https://disk.yandex.ru/d/o-H6XphFQGPUqQ).