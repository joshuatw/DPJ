/* 
 * Copyright 2002-2005 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

/*
 * @test
 * @bug 4670772 6328529
 * @summary Completion failures should be ignored in javadoc.
 * @author gafter
 */

import com.sun.javadoc.*;
import java.util.*;

public class CompletionFailure extends Doclet
{
    public static void main(String[] args) {
	// run javadoc on package pkg
	if (com.sun.tools.javadoc.Main.execute("javadoc",
					       "CompletionFailure",
					       new String[]{"pkg"}) != 0)
	    throw new Error();
    }

    public static boolean start(com.sun.javadoc.RootDoc root) {
	ClassDoc[] classes = root.classes();
	if (classes.length != 1)
	    throw new Error("1 " + Arrays.asList(classes));
	return true;
    }
}
