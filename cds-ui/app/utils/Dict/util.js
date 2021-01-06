
export function getDictDataMappings (dictData = []) {
  return dictData.reduce(function(acc, curValue) {
    acc[curValue.id] = curValue.name;
    return acc;
  }, {});
};