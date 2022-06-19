package org.intellij.sdk.model.impl;

import org.intellij.sdk.model.BaseModel;

import java.util.Arrays;
import java.util.List;

public class SimpleModel implements BaseModel {
    List<String> candidates = Arrays.asList("a1", "a2", "a3", "a4", "a5");

    @Override
    public List<String> getCandidates(String word, int n) {
        return this.candidates;
    }

    public static void main(String[] args) {
        SimpleModel model = new SimpleModel();

        List<String> candidates = model.getCandidates("myName", 10);

        for (String el : candidates) {
            System.out.println(el);
        }
    }
}
