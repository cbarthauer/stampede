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
package analyzer;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FileSystemSourceDistributionTest {
    private static final String VISTA_FOIA_PATH = "D:\\mspace\\VistA-FOIA";
    private static final String ACCOUNTS_RECEIVABLE_PATH = "D:\\mspace\\VistA-FOIA\\Packages\\Accounts Receivable\\Routines";
    
    @Test
    public void countFilesInDistribution() {
        File file = new File(VISTA_FOIA_PATH);
        SourceDistribution distribution = new FileSystemSourceDistribution(
                file);
        List<MumpsRoutine> routineList = new ArrayList<MumpsRoutine>();
        Iterator<MumpsRoutine> routineIterator = distribution.iterator();
        
        while(routineIterator.hasNext()) {
            routineList.add(routineIterator.next());
        }
        
        assertThat(25074, equalTo(routineList.size()));
    }
    
    @Test
    public void countFilesInAccountsReceivableFolder() {
        File file = new File(ACCOUNTS_RECEIVABLE_PATH);
        SourceDistribution distribution = new FileSystemSourceDistribution(
                file);
        List<MumpsRoutine> routineList = new ArrayList<MumpsRoutine>();
        Iterator<MumpsRoutine> routineIterator = distribution.iterator();
        
        while(routineIterator.hasNext()) {
            routineList.add(routineIterator.next());
        }
        
        assertThat(467, equalTo(routineList.size()));       
    }
}
