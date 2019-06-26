/*
 * This file is licensed under the MIT License and part of the "dblapi"-project.
 * Copyright (c) 2019 Daniel Riegler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package yt.syntax.dbl.api.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * Representation of the User schema found at the official DBL
 * <a href="https://discordbots.org/api/docs#users">API documentation</a>
 */
@Getter
@Accessors(fluent = true)
@SuppressWarnings("unused")
public class User extends BaseUser
{

    /**
     * the bio of the user (can be {@code NULL})
     */
    String bio;

    /**
     * the banner image url of the user (can be {@code NULL})
     */
    String banner;

    /**
     * the social profile page names of the user
     */
    @NonNull Social social;

    /**
     * the hex color of the user (can be {@code NULL})
     */
    String color;

    /**
     * {@code TRUE} if the user's a supporter
     */
    boolean supporter;

    /**
     * {@code TRUE} if the user's a certified supporter
     */
    @SerializedName("certifiedDev")
    boolean certifiedDevelope;

    /**
     * {@code TRUE} if the user's a moderator
     */
    @SerializedName("mod")
    boolean moderator;

    /**
     * {@code TRUE} if the user's a web moderator
     */
    @SerializedName("webMod")
    boolean webModerator;

    /**
     * {@code TRUE} if the user's an administrator
     */
    @SerializedName("admin")
    boolean administrator;

    /**
     * Social profile page names
     */
    @Getter
    @Accessors(fluent = true)
    public class Social
    {

        /**
         * the Youtube channel id of the user (can be {@code NULL})
         */
        String youtub;

        /**
         * the Reddit profile name of the user (can be {@code NULL})
         */
        String reddit;

        /**
         * the Twitter profile name of the user (can be {@code NULL})
         */
        String twitter;

        /**
         * the Instagram profile name of the user (can be {@code NULL})
         */
        String instagram;

        /**
         * the Github profile name of the user
         */
        String github;

    }

}
