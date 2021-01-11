interface IDictItem {
  id: string | number,
  name: string
}

interface IColDef {
  refData?: IDictItem[] | object
}

interface IPropertyDescriptor extends PropertyDescriptor {
  initializer?: (params: any) => {}
}

/**
 * 翻译单个数据，例如：交易方向first => 一级申购（网下）
 * @param {*} dictData [{ id: xx, name: xx }]
 * @param {*} key 待提取的属性
 * @param {*} value 待翻译的原始数据，为字典的key值
 */
export function translate(dictData: IDictItem[] = [], value: string | number, key: string = 'id') {
  return dictData.find((item: IDictItem) => (item[key] == value) && item.name);
}

/**
 * 提取字典值 [name1, name2, ……]
 * @param {*} dictData [{ id: xx, name: xx }]
 * @param {*} key 待提取的属性
 */
export function extractValues(dictData: IDictItem[] = [], key: string = 'id') {
  return dictData.reduce((results: (string | number)[], curValue: IDictItem) => {
    results.push(curValue[key]);
    return results;
  }, []);
}

/**
 * 适用于 react hook 组件中
 * @param {*} columns 
 */ 
export function mapAgRefDataFunc(columns: any[] = []) {
  /**
   * 将 [{id: 1, name: '是'}] 转成 { 1: '是' }
   * @param {*} dictData 字典数据
   */
  function getMappings(dictData: IDictItem[] = []) {
    return dictData.reduce((acc, curValue) => {
      acc[curValue.id] = curValue.name;
      return acc;
    }, {});
  }

  columns.forEach((item: IColDef) => {
    // 如果 ref 的值是一个数组， 说明是需要处理成 object
    if (item && item.refData && item.refData instanceof Array) {
      item.refData = getMappings(item.refData);
    }
  });
  return columns;
}

/**
 * 将 colDef 中的 refData 数据结构转换成 ag-grid refData 的数据结构
 * @param {*} target
 * @param {*} name
 * @param {*} descriptor
 */
export function mapAgRefData(target: any, name: string, descriptor: IPropertyDescriptor) {
  const key = descriptor.value ? 'value' : 'initializer';
  const fn = descriptor[key];

  if (typeof fn === 'function') {
    descriptor.initializer = function() {
      return function(...args: any[]) {
        const columns = key === 'value' ? fn.apply(this, args) : fn.call(this).apply(this, args);
        return mapAgRefDataFunc(columns);
      };
    };
  }
  return descriptor;
}
