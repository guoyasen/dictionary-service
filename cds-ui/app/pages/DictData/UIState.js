import { observable, action } from 'mobx';
import { last } from 'lodash';

class UiState {
  @observable dictItemKeys = []; // 字典子项对应 key 值, 即:[{ key: 0 }, { key: 1 }]

  setDictItemKeys = action((keys) => {
    this.dictItemKeys = keys;
  });

  // 添加字典子项
  addDictItem = action(() => {
    const lastKey = last(this.dictItemKeys).key;
    this.dictItemKeys.push({
      key: lastKey + 1
    });
  });

  /**
   * 移除字典子项
   * @params key 被移除子项对应 key
   */
  removeDictItem = action((key) => {
    const dictItemKeys = this.dictItemKeys; // 字典子项列表
    const len = dictItemKeys.length;
    for (let i = 0; i < len; i++) {
      if (dictItemKeys[i].key === key) {
        dictItemKeys[i] = {
          key: key,
          removed: true // 标记该项已被移除
        };
        break;
      }
    }
  });
}

export default UiState;
