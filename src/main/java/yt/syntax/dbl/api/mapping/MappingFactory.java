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

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@SuppressWarnings("unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MappingFactory
{

    /**
     * @return - an instance of {@link MappingBuilder}
     */
    public static MappingBuilder builder()
    {
        return new MappingBuilder();
    }

    /**
     * Creates a synchronous mapping instance
     *
     * @param token - an authentication token of the discordbots.org API
     * @param botId - id of the bot itself
     * @return {@link ISyncMapping}
     */
    public static ISyncMapping sync(final @NonNull String token, final @NonNull Number botId)
    {
        return new MappingBuilder().token(token).botId(botId).build().sync();
    }

    /**
     * Creates an asynchronous mapping instance
     *
     * @param token - an authentication token of the discordbots.org API
     * @param botId - id of the bot itself
     * @return {@link IAsyncMapping}
     */
    public static IAsyncMapping async(final @NonNull String token, final @NonNull Number botId)
    {
        return new MappingBuilder().token(token).botId(botId).build().async();
    }

}
