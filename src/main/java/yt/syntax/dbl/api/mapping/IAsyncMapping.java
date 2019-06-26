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

package yt.syntax.dbl.api.mapping;

import retrofit2.http.*;
import yt.syntax.dbl.api.model.Bot;
import yt.syntax.dbl.api.model.User;

import java.util.concurrent.CompletableFuture;

/**
 * Asynchronous endpoint mapping of the <a href="https://discordbots.org/api/docs">discordbots.org</a> API
 * {@code $botid$} is a placeholder which gets replaced by the actual id of the bot during the request chain
 */
@SuppressWarnings("unused")
public interface IAsyncMapping
{

    @GET("/api/users/{id}")
    CompletableFuture<User> user(final @Path("id") Number userId);

    @GET("/api/bots/{id}")
    CompletableFuture<Bot> bot(final @Path("id") Number botId);

    @GET("/api/bots/$botid$")
    CompletableFuture<Bot> bot();

    @GET("/api/bots/{id}/votes")
    CompletableFuture<User[]> votes(final @Path("id") Number botId);

    @GET("/api/bots/$botid$/votes")
    CompletableFuture<User[]> votes();

    @GET("/api/bots/{id}/check")
    CompletableFuture<Boolean> check(final @Path("id") Number botId, final @Query("userId") Number userId);

    @GET("/api/bots/$botid$/check")
    CompletableFuture<Boolean> check(final @Query("userId") Number userId);

    @GET("/api/bots/{id}/stats")
    CompletableFuture<Bot.Stats> stats(final @Path("id") Number botId);

    @GET("/api/bots/$botid$/stats")
    CompletableFuture<Bot.Stats> stats();

    @POST("/api/bots/{id}/stats")
    CompletableFuture<Void> stats(
            final @Path("id") Number botId,
            final @Field("server_count") Number servers,
            final @Field("shards") Number[] shards,
            final @Field("shard_id") Number shardId,
            final @Field("shard_count") Number shardCount
    );

    @POST("/api/bots/$botid$/stats")
    CompletableFuture<Void> stats(
            final @Field("server_count") Number servers,
            final @Field("shards") Number[] shards,
            final @Field("shard_id") Number shardId,
            final @Field("shard_count") Number shardCount
    );

}
