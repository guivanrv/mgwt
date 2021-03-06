/*
 * Copyright 2011 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.ui.client.widget.input;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.IntegerBox;

import com.googlecode.mgwt.ui.client.widget.base.MValueBoxBase;

/**
 * An input element that handles integers
 *
 * @author Daniel Kurka
 */
public class MIntegerBox extends MValueBoxBase<Integer> {

  private static class SIntegerBox extends IntegerBox implements HasSource {

    private Object source;

    public SIntegerBox() {
      setStylePrimaryName("gwt-IntegerBox");
    }

    @Override
    protected HandlerManager createHandlerManager() {
      return new HandlerManager(source);
    }

    @Override
    public void setSource(Object source) {
      this.source = source;

    }
  }

  public MIntegerBox() {
    this(InputAppearanceHolder.DEFAULT_APPEARANCE);
  }

  public MIntegerBox(InputAppearance appearance) {
    super(appearance, new SIntegerBox());
    impl.setType(box.getElement(), "number");
    addStyleName(appearance.css().textBox());
  }
}
