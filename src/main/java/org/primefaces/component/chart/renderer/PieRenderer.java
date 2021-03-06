/*
 * Copyright 2009-2013 PrimeTek.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.primefaces.component.chart.renderer;

import java.io.IOException;
import java.util.Iterator;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import org.primefaces.component.chart.Chart;
import org.primefaces.model.chart.PieChartModel;

public class PieRenderer extends BasePlotRenderer {
    
    @Override
    protected void encodeData(FacesContext context, Chart chart) throws IOException {
		ResponseWriter writer = context.getResponseWriter();
        PieChartModel model = (PieChartModel) chart.getModel();

		writer.write(",data:[[" );
        for(Iterator<String> it = model.getData().keySet().iterator(); it.hasNext();) {
            String key = it.next();
            Number value = model.getData().get(key);

            writer.write("[\"" + key + "\"," + value + "]");

            if(it.hasNext()) {
                writer.write(",");
            }
        }
        writer.write("]]");
	}
    
    @Override
    protected void encodeOptions(FacesContext context, Chart chart) throws IOException {
        super.encodeOptions(context, chart);
		
        ResponseWriter writer = context.getResponseWriter();
        PieChartModel model = (PieChartModel) chart.getModel();
        int diameter = model.getDiameter();
        int sliceMargin = model.getSliceMargin();
        boolean fill = model.isFill();
        boolean showDataLabels = model.isShowDataLabels();
        String dataFormat = model.getDataFormat();
 
        if(diameter != 0) writer.write(",diameter:" + sliceMargin);
        if(sliceMargin != 0) writer.write(",sliceMargin:" + sliceMargin);
        if(!fill) writer.write(",fill:false");
        if(showDataLabels) writer.write(",showDataLabels:true");
        if(dataFormat != null) writer.write(",dataFormat:'" + dataFormat + "'");
    }
    
}
