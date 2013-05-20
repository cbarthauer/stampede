/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sonar;

import java.util.Collection;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.rules.RuleQuery;

class NullRuleFinder implements RuleFinder {

    @Override
    public Rule findById(int i) {
        return null;
    }

    @Override
    public Rule findByKey(String string, String string1) {
        return null;
    }

    @Override
    public Rule find(RuleQuery rq) {
        return null;
    }

    @Override
    public Collection<Rule> findAll(RuleQuery rq) {
        return null;
    }

}
