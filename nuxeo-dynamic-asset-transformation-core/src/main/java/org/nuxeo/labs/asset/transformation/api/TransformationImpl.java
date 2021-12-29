/*
 * (C) Copyright 2021 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Michael Vachette
 */

package org.nuxeo.labs.asset.transformation.api;

import org.nuxeo.ecm.core.api.Blob;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TransformationImpl implements Transformation {

    protected long width;
    protected long height;
    protected String format;
    protected CropBox cropBox;
    protected double ratio;
    protected String textWatermark;
    protected Blob imageWatermark;

    @Override
    public long getWidth() {
        return width;
    }

    @Override
    public void setWidth(long width) {
        this.width = width;
    }

    @Override
    public long getHeight() {
        return height;
    }

    @Override
    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public CropBox getCropBox() {
        return cropBox;
    }

    @Override
    public void setCropBox(CropBox box) {
        this.cropBox = box;
        this.ratio = this.cropBox.getRatio();
    }

    @Override
    public double getCropRatio() {
        return ratio;
    }

    @Override
    public void setCropRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String getTextWatermark() {
        return textWatermark;
    }

    @Override
    public void setTextWatermark(String textWatermark) {
        this.textWatermark = textWatermark;
    }

    @Override
    public Blob getImageWatermark() {
        return imageWatermark;
    }

    @Override
    public void setImageWatermark(Blob imageWatermark) {
        this.imageWatermark = imageWatermark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransformationImpl that = (TransformationImpl) o;
        return width == that.width && height == that.height && Double.compare(that.ratio, ratio) == 0 &&
                Objects.equals(format, that.format) && Objects.equals(cropBox, that.cropBox) &&
                Objects.equals(textWatermark, that.textWatermark) && Objects.equals(imageWatermark, that.imageWatermark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height, format, cropBox, ratio, textWatermark, imageWatermark);
    }

    @Override
    public Map<String, Serializable> toMap() {
        Map<String, Serializable> map = new HashMap<>();
        map.put("width", "" + width);
        map.put("height", "" + height);
        map.put("format", format);
        map.put("crop", cropBox.toString());
        map.put("textWatermark",textWatermark);
        return map;
    }

}
