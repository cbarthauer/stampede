package sonar;

import java.util.List;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.api.rules.XMLRuleParser;

/**
 *
 * @author cbarthauer
 */
public class MumpsRuleRepository extends RuleRepository {
    public final static String KEY = "mumpsAnalyzer";
    
    private final XMLRuleParser ruleParser;

    public MumpsRuleRepository(XMLRuleParser ruleParser) {
        super(KEY, Mumps.KEY);
        setName("MumpsAnalyzer");
        this.ruleParser = ruleParser;
    }
    
    @Override
    public List<Rule> createRules() {
        return ruleParser.parse(getClass().getResourceAsStream("/sonar/rules.xml"));
    }
    
}
