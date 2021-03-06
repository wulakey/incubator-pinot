/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pinot.core.query.selection.iterator;

import java.io.Serializable;
import org.apache.pinot.core.common.Block;


/**
 * Iterator on int array column selection query.
 *
 */
public class IntArraySelectionColumnIterator extends SelectionMultiValueColumnIterator {

  public IntArraySelectionColumnIterator(Block block) {
    super(block);
  }

  @Override
  public Serializable getValue(int docId) {
    bvIter.skipTo(docId);
    int dictSize = bvIter.nextIntVal(dictIds);
    int[] rawIntRow = new int[dictSize];
    for (int dictIdx = 0; dictIdx < dictSize; ++dictIdx) {
      rawIntRow[dictIdx] = (Integer) (dict.get(dictIds[dictIdx]));
    }
    return rawIntRow;
  }
}
