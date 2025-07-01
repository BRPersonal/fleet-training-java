package com.fleet.training.misc;

import java.util.Objects;

public record User(String username, String email, boolean active)
{
    public User
    {
        Objects.requireNonNull(username, "Username cannot be null");
        Objects.requireNonNull(email, "email cannot be null");

        if (username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        if (email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public static class Builder
    {
        private String username;
        private String email;
        private boolean active = true;

        public Builder username(String username)
        {
            this.username = username;
            return this;
        }

        public Builder email(String email)
        {
            this.email = email;
            return this;
        }

        public Builder active(boolean active)
        {
            this.active = active;
            return this;
        }

        public User build()
        {
            return new User(username,email,active);
        }
    }
}
