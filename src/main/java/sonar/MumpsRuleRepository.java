/**
 * Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
 *
 * This file is part of STAMPEDE.
 *
 * STAMPEDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * STAMPEDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
package sonar;

import java.util.List;
import org.sonar.api.rules.Rule;
import org.sonar.api.rules.RuleRepository;
import org.sonar.api.rules.XMLRuleParser;

/**
 * Represents code quality rules for the MUMPS programming
 * language in Sonar.
 * 
 * @author cbarthauer
 */
public final class MumpsRuleRepository extends RuleRepository {
    /**
     * The unique identifier for the MUMPS rule repository
     * within Sonar.
     */
    public static final String KEY = "mumpsAnalyzer";
    
    private final XMLRuleParser ruleParser;

    /**
     * Creates a MumpsRuleRepository configured with the given
     * XMLRuleParser. Called by the Sonar dependency injection
     * mechanism.
     * 
     * @param ruleParser which will parse the MUMPS code quality
     *   rules file (See /sonar/rules.xml).
     */
    public MumpsRuleRepository(XMLRuleParser ruleParser) {
        super(KEY, Mumps.KEY);
        setName("STAMPEDE");
        this.ruleParser = ruleParser;
    }
    
    @Override
    public final List<Rule> createRules() {
        return ruleParser.parse(getClass().getResourceAsStream("/sonar/rules.xml"));
    }
    
}
