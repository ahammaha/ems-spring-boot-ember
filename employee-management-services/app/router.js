import EmberRouter from '@ember/routing/router';
import config from './config/environment';

const Router = EmberRouter.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('employee', function() {
    this.route('add');
    this.route('disp-employee',{path: '/:employee_id'});
    this.route('empdetails');
    this.route('edit',{path: '/:employee_id/edit'});
    this.route('tasks',{path: '/:employee_id/tasks'});
    this.route('addtask',{path: '/:employee_id/addtask'});
  });
});

export default Router;
