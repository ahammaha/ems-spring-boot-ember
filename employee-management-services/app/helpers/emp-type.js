import { helper } from '@ember/component/helper';

export function empType(params/*, hash*/) {
  if(params[0]=="PERMENANT"){
    return "Permanent";
  }
  return "Contract";
}

export default helper(empType);
