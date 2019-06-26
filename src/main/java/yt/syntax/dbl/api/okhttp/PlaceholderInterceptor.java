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

package yt.syntax.dbl.api.okhttp;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class PlaceholderInterceptor implements Interceptor
{

    private static final Pattern REGEX = Pattern.compile("\\$(\\w.*?)\\$", Pattern.CASE_INSENSITIVE);

    private final @NonNull Map<String, String> placeholders;

    @Override
    public Response intercept(final Chain chain) throws IOException
    {
        return chain.proceed(chain.request().newBuilder().url(REGEX.matcher(chain.request().url().toString()).
                replaceAll(result -> this.placeholders.getOrDefault(result.group(1), "undefined"))).
                build());
    }

}
