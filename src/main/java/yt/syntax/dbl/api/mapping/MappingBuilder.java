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

import com.fatboyindustrial.gsonjavatime.OffsetDateTimeConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import yt.syntax.dbl.api.DiscordBotsException;
import yt.syntax.dbl.api.okhttp.AuthorizationInterceptor;
import yt.syntax.dbl.api.okhttp.PlaceholderInterceptor;

import java.time.OffsetDateTime;
import java.util.HashMap;

@Setter
@Accessors(fluent = true)
@SuppressWarnings({"unused", "WeakerAccess"})
public class MappingBuilder
{

    private @NonNull Gson gson = new GsonBuilder().
            serializeNulls().
            disableHtmlEscaping().
            registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeConverter()).
            create();

    private @NonNull HttpUrl baseUrl = HttpUrl.parse("https://discordbots.org");

    private @NonNull String token;

    private @NonNull Number botId;

    public Mappings build()
    {
        if (null == this.token)
            throw new DiscordBotsException("Please provide an authentication token.");
        if (null == this.botId)
            throw new DiscordBotsException("Please provide a bot id.");
        return new Mappings(this);
    }

    public class Mappings
    {

        private final Retrofit retrofit;

        private ISyncMapping sync;

        private IAsyncMapping async;

        private Mappings(final MappingBuilder instance)
        {
            // placeholder for request urls
            final var placeholders = new HashMap<String, String>();
            placeholders.put("botid", instance.botId.toString());

            this.retrofit = new Retrofit.Builder().
                    baseUrl(instance.baseUrl).
                    addConverterFactory(GsonConverterFactory.create(instance.gson)).
                    client(new OkHttpClient.Builder().
                            addInterceptor(new AuthorizationInterceptor(instance.token)).
                            addInterceptor(new PlaceholderInterceptor(placeholders)).
                            build()).
                    build();
        }

        public ISyncMapping sync()
        {
            if (null == this.sync)
                this.sync = this.retrofit.create(ISyncMapping.class);
            return this.sync;
        }

        public IAsyncMapping async()
        {
            if (null == this.async)
                this.async = this.retrofit.create(IAsyncMapping.class);
            return this.async;
        }
    }
}
