import { helper } from '@ember/component/helper';

export function printDesignation(params/*, hash*/) {
  let val=params[0];
  if(val=="INTERN"){
    return "Intern";
  } else if(val=="SOFTWARE_DEVELOPER"){
    return "Software Developer";
  } else if(val=="PROJECT_MANAGER"){
    return "Project Manager";
  } else if(val=="HR"){
    return "HR";
  }
  return "-";
}

export default helper(printDesignation);
