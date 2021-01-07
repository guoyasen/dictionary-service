

/**
 * 提取字典值
 * @param {*} dictData [{ id: xx, name: xx }]
 * @param {*} key 待提取的属性
 */
export function extractValues(dictData = [], key = 'id') {
  return dictData.reduce((results, curValue) => {
    results.push(curValue[key]);
    return results;
  }, []);
};

/**
 * 将 colDef 中的 refData 数据结构转换成 ag-grid refdata 的数据结构
 * @param {*} target 
 * @param {*} name 
 * @param {*} descriptor 
 */
export function mapRefData(target, name, descriptor) {
  
  const key = descriptor.value ? 'value' : 'initializer';
  const fn = descriptor[key];

  /**
   * 将 [{id: 1, name: '是'}] 转成 { 1: '是' }
   * @param {*} dictData 字典数据
   */
  function getMappings(dictData = []) {
    return dictData.reduce(function(acc, curValue) {
      acc[curValue.id] = curValue.name;
      return acc;
    }, {});
  };

  function mappingColDefs(columns = []) {
    columns.forEach(item => {
      // 如果 ref 的值是一个数组， 说明是需要处理成 object
      if (item && item.refData && (item.refData instanceof Array)) {
        item.refData = getMappings(item.refData);
      }
    })
    return columns;
  }

  if (typeof fn === 'function') {
    descriptor.initializer = function() {
      return function(...args) {
        const columns = key === 'value' ? fn.apply(this, args) : fn.call(this).apply(this, args);
        return mappingColDefs(columns);
      }
    }
  }
  return descriptor;
}