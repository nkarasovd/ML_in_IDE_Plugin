package org.intellij.sdk.model;

import java.util.List;

public interface BaseModel {
    List<String> getCandidates(String word, int n);
}
