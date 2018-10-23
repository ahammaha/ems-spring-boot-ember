import { helper } from '@ember/component/helper';

export function empType(params/*, hash*/) {
  if(params[0]=="PERMENANT"){
    return "Permanent";
  } else if(params[0]=="CONTRACT") {
    return "Contract";
  }
  return "-";
}

export default helper(empType);
