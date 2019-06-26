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

import java.time.OffsetDateTime;

/**
 * Representation of the Bot schema found at the official DBL
 * <a href="https://discordbots.org/api/docs#bots">API documentation</a>
 */
@Getter
@Accessors(fluent = true)
@SuppressWarnings("unused")
public class Bot extends BaseUser
{

    /**
     * the name of the library the bot's written in
     */
    @NonNull
    @SerializedName("lib")
    String library;

    /**
     * the command prefix of the bot
     */
    @NonNull String prefix;

    /**
     * the short description of the bot
     */
    @NonNull String shortDescription;

    /**
     * the long description of the bot (can be {@code NULL})
     */
    String description;

    /**
     * the bot's tags
     */
    @NonNull String[] tags;

    /**
     * the website url of the bot (can be {@code NULL})
     */
    String website;

    /**
     * the support server invitation code of the bot (can be {@code NULL})
     */
    String support;

    /**
     * the Github repository url of the bot (can be {@code NULL})
     */
    String github;

    /**
     * the bot's owners; first one in the array is the main owner
     */
    @NonNull Number[] owners;

    /**
     * the guilds featured on the bot's page
     */
    @NonNull Number[] guilds;

    /**
     * the invitation url of the bot (can be {@code NULL})
     */
    String invite;

    /**
     * the approval date of the bot
     */
    @NonNull OffsetDateTime date;

    /**
     * {@code TRUE} if the bot's a certified one
     */
    boolean certified;

    /**
     * the "vanity"-url of the bot (can be {@code NULL})
     */
    String vanity;

    /**
     * the amount of up-votes of the bot
     */
    @NonNull Number points;

    /**
     * the amount of up-votes the bot had this month
     */
    @NonNull Number monthlyPoints;

    /**
     * the id of the guild with a donate-bot setup
     */
    @NonNull
    @SerializedName("donatebotguildid")
    String donateBotGuild;

    /**
     * Bot stats
     */
    @Getter
    @Accessors(fluent = true)
    public class Stats
    {

        /**
         * the amount of servers the bot's joined (can be {@code NULL})
         */
        @SerializedName("server_count")
        Number serverCount;

        @NonNull Number[] shards;

        /**
         * the amount of active shards of the bot (can be {@code NULL})
         */
        @SerializedName("shard_count")
        Number shardCount;

    }

}
