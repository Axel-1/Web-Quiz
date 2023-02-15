package io.github.axel1.webquiz.appreciationNumerique;

import io.github.axel1.webquiz.model.entity.IAppreciation;

public class AppreciationInt implements IAppreciation {
    private final int appreciation;

    public AppreciationInt(String appreciation) {
        this.appreciation = Integer.parseInt(appreciation);
    }

    @Override
    public String getAppreciation() {
        return String.valueOf(appreciation);
    }
}
