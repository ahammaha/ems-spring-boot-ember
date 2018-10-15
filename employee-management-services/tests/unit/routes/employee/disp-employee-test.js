import { module, test } from 'qunit';
import { setupTest } from 'ember-qunit';

module('Unit | Route | employee/disp-employee', function(hooks) {
  setupTest(hooks);

  test('it exists', function(assert) {
    let route = this.owner.lookup('route:employee/disp-employee');
    assert.ok(route);
  });
});
