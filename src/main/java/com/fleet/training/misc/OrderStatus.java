package com.fleet.training.misc;

public enum OrderStatus
{
    PLACED {
        @Override
        public boolean isTerminalState()
        {
            return false;
        }

        @Override
        public OrderStatus next()
        {
            return PAYMENT_PENDING;
        }
    },
    PAYMENT_PENDING {
        @Override
        public boolean isTerminalState()
        {
            return false;
        }

        @Override
        public OrderStatus next()
        {
            return PAYMENT_CONFIRMED;
        }
    },
    PAYMENT_CONFIRMED {
        @Override
        public boolean isTerminalState()
        {
            return false;
        }

        @Override
        public OrderStatus next()
        {
            return PROCESSING;
        }
    },
    PROCESSING {
        @Override
        public boolean isTerminalState()
        {
            return false;
        }

        @Override
        public OrderStatus next()
        {
            return SHIPPED;
        }
    },
    SHIPPED {
        @Override
        public boolean isTerminalState()
        {
            return false;
        }

        @Override
        public OrderStatus next()
        {
            return COMPLETED;
        }
    },
    COMPLETED {
        @Override
        public boolean isTerminalState()
        {
            return true;
        }

        @Override
        public OrderStatus next()
        {
            throw new UnsupportedOperationException("Reached Terminal State");
        }
    };

    public abstract boolean isTerminalState();
    public abstract OrderStatus next();
    public static OrderStatus getInitialState()
    {
        return PLACED;
    }
}
