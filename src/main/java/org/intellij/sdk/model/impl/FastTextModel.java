package org.intellij.sdk.model.impl;

import org.deeplearning4j.models.fasttext.FastText;
import org.intellij.sdk.model.BaseModel;

import java.io.File;
import java.util.List;


public class FastTextModel implements BaseModel {
    String modelPath = "src/main/resources/model/";
    String modelName = "improved_model_only_java_names_with_digits_swords_deleted_10_epochs.vec";
    FastText model;

    public FastTextModel() {
        this.model = new FastText();
        this.model.loadPretrainedVectors(new File(this.modelPath + this.modelName));
    }

    public List<String> getCandidates(String word, int n) {
        return (List<String>) this.model.wordsNearest(word, n);
    }

    public static void main(String[] args) {
        FastTextModel model = new FastTextModel();

        List<String> candidates = model.getCandidates("myName", 10);

        for (String el : candidates) {
            System.out.println(el);
        }
    }
}
