/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.filemanager;

import org.xwiki.model.reference.DocumentReference;

/**
 * Represents a path in the file system. A path is uniquely determined either by a folder or by a (folder, file) pair. A
 * file cannot specify the path alone because files can have multiple parent folders (so a file can have multiple
 * paths).
 * 
 * @version $Id$
 * @since 2.0M1
 */
public class Path
{
    /**
     * Specifies the folder.
     */
    private final DocumentReference folderReference;

    /**
     * Specifies the file.
     */
    private final DocumentReference fileReference;

    /**
     * Creates a new path that is determined by the specified folder. Folders have one single path.
     * 
     * @param folderReference a reference to a document that represents a folder
     */
    public Path(DocumentReference folderReference)
    {
        this(folderReference, null);
    }

    /**
     * Creates a new path that is determined by the given (folder, file) pair. Files can have multiple paths (because
     * they can have multiple parent folders) so you need to choose a parent in order to determine the path.
     * 
     * @param folderReference a reference to a document that represents a folder
     * @param fileReference a reference to a document that represents a file
     */
    public Path(DocumentReference folderReference, DocumentReference fileReference)
    {
        this.folderReference = folderReference;
        this.fileReference = fileReference;
    }

    /**
     * @return the folder reference
     */
    public DocumentReference getFolderReference()
    {
        return folderReference;
    }

    /**
     * @return the file reference, or {@code null} if this path was specified only by its folder
     */
    public DocumentReference getFileReference()
    {
        return fileReference;
    }
}
