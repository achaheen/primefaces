/*
 * Copyright 2014 jagatai.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.model.chart;

import java.util.HashMap;

public class BarChartModel extends CartesianChartModel {
    
    private int barPadding = 8;
    private int barMargin = 10;
    
    @Override
    public void createAxes() {
        axes = new HashMap<AxisType, Axis>();
        axes.put(AxisType.X, new CategoryAxis());
        axes.put(AxisType.Y, new LinearAxis());
    }

    public String getOrientation() {
        return "vertical";
    }

    public int getBarPadding() {
        return barPadding;
    }

    public void setBarPadding(int barPadding) {
        this.barPadding = barPadding;
    }

    public int getBarMargin() {
        return barMargin;
    }

    public void setBarMargin(int barMargin) {
        this.barMargin = barMargin;
    }  
}
