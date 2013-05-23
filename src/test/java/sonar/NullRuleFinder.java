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
