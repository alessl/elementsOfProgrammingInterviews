package com.leonenko.epi._4_primitive;

import lombok.Data;

public class _411_RectangleIntersection {

    static Rectangle getIntersectionRectangle(Rectangle rect1, Rectangle rect2) {
        if (!rect1.intersects(rect2)) {
            return null;
        }

        var x = Math.max(rect1.x, rect2.x);
        var y = Math.max(rect1.y, rect2.y);
        var width = Math.min(rect1.x + rect1.width, rect2.x + rect2.width) - x;
        var height = Math.min(rect1.y + rect1.height, rect2.y + rect2.height) - y;

        return new Rectangle(x, y, width, height);
    }

    @Data
    static final class Rectangle {
        private final int x;
        private final int y;
        private final int width;
        private final int height;

        public boolean intersects(Rectangle otherRect) {
            return x <= otherRect.x + otherRect.width && x + width >= otherRect.x
                    && x <= otherRect.y + otherRect.width && y + height >= otherRect.y;
        }
    }
}
