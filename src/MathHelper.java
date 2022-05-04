import net.minecraft.core.Vec3i;
import java.util.Random;
import java.util.UUID;

public class MathHelper {
    public static final float SQRT_2 = sqrt_float(2.0F);
    private static final float[] SIN_TABLE = new float[65536];
    private static final int[] multiplyDeBruijnBitPosition;
    private static final double field_181163_d;
    private static final double[] field_181164_e;
    private static final double[] field_181165_f;

    public static float sin(float p_sin_0_) {
        return SIN_TABLE[(int)(p_sin_0_ * 10430.378F) & '\uffff'];
    }

    public static float cos(float p_cos_0_) {
        return SIN_TABLE[(int)(p_cos_0_ * 10430.378F + 16384.0F) & '\uffff'];
    }

    public static float sqrt_float(float p_sqrt_float_0_) {
        return (float)Math.sqrt((double)p_sqrt_float_0_);
    }

    public static float sqrt_double(double p_sqrt_double_0_) {
        return (float)Math.sqrt(p_sqrt_double_0_);
    }

    public static int floor_float(float p_floor_float_0_) {
        int lvt_1_1_ = (int)p_floor_float_0_;
        return p_floor_float_0_ < (float)lvt_1_1_ ? lvt_1_1_ - 1 : lvt_1_1_;
    }


    public static int truncateDoubleToInt(double p_truncateDoubleToInt_0_) {
        return (int)(p_truncateDoubleToInt_0_ + 1024.0D) - 1024;
    }

    public static int floor_double(double p_floor_double_0_) {
        int lvt_2_1_ = (int)p_floor_double_0_;
        return p_floor_double_0_ < (double)lvt_2_1_ ? lvt_2_1_ - 1 : lvt_2_1_;
    }

    public static long floor_double_long(double p_floor_double_long_0_) {
        long lvt_2_1_ = (long)p_floor_double_long_0_;
        return p_floor_double_long_0_ < (double)lvt_2_1_ ? lvt_2_1_ - 1L : lvt_2_1_;
    }


    public static int func_154353_e(double p_154353_0_) {
        return (int)(p_154353_0_ >= 0.0D ? p_154353_0_ : -p_154353_0_ + 1.0D);
    }

    public static float abs(float p_abs_0_) {
        return p_abs_0_ >= 0.0F ? p_abs_0_ : -p_abs_0_;
    }

    public static int abs_int(int p_abs_int_0_) {
        return p_abs_int_0_ >= 0 ? p_abs_int_0_ : -p_abs_int_0_;
    }

    public static int ceiling_float_int(float p_ceiling_float_int_0_) {
        int lvt_1_1_ = (int)p_ceiling_float_int_0_;
        return p_ceiling_float_int_0_ > (float)lvt_1_1_ ? lvt_1_1_ + 1 : lvt_1_1_;
    }

    public static int ceiling_double_int(double p_ceiling_double_int_0_) {
        int lvt_2_1_ = (int)p_ceiling_double_int_0_;
        return p_ceiling_double_int_0_ > (double)lvt_2_1_ ? lvt_2_1_ + 1 : lvt_2_1_;
    }

    public static int clamp_int(int p_clamp_int_0_, int p_clamp_int_1_, int p_clamp_int_2_) {
        if (p_clamp_int_0_ < p_clamp_int_1_) {
            return p_clamp_int_1_;
        } else {
            return p_clamp_int_0_ > p_clamp_int_2_ ? p_clamp_int_2_ : p_clamp_int_0_;
        }
    }

    public static float clamp_float(float p_clamp_float_0_, float p_clamp_float_1_, float p_clamp_float_2_) {
        if (p_clamp_float_0_ < p_clamp_float_1_) {
            return p_clamp_float_1_;
        } else {
            return p_clamp_float_0_ > p_clamp_float_2_ ? p_clamp_float_2_ : p_clamp_float_0_;
        }
    }

    public static double clamp_double(double p_clamp_double_0_, double p_clamp_double_2_, double p_clamp_double_4_) {
        if (p_clamp_double_0_ < p_clamp_double_2_) {
            return p_clamp_double_2_;
        } else {
            return p_clamp_double_0_ > p_clamp_double_4_ ? p_clamp_double_4_ : p_clamp_double_0_;
        }
    }

    public static double denormalizeClamp(double p_denormalizeClamp_0_, double p_denormalizeClamp_2_, double p_denormalizeClamp_4_) {
        if (p_denormalizeClamp_4_ < 0.0D) {
            return p_denormalizeClamp_0_;
        } else {
            return p_denormalizeClamp_4_ > 1.0D ? p_denormalizeClamp_2_ : p_denormalizeClamp_0_ + (p_denormalizeClamp_2_ - p_denormalizeClamp_0_) * p_denormalizeClamp_4_;
        }
    }

    public static double abs_max(double p_abs_max_0_, double p_abs_max_2_) {
        if (p_abs_max_0_ < 0.0D) {
            p_abs_max_0_ = -p_abs_max_0_;
        }

        if (p_abs_max_2_ < 0.0D) {
            p_abs_max_2_ = -p_abs_max_2_;
        }

        return p_abs_max_0_ > p_abs_max_2_ ? p_abs_max_0_ : p_abs_max_2_;
    }


    public static int bucketInt(int p_bucketInt_0_, int p_bucketInt_1_) {
        return p_bucketInt_0_ < 0 ? -((-p_bucketInt_0_ - 1) / p_bucketInt_1_) - 1 : p_bucketInt_0_ / p_bucketInt_1_;
    }

    public static int getRandomIntegerInRange(Random p_getRandomIntegerInRange_0_, int p_getRandomIntegerInRange_1_, int p_getRandomIntegerInRange_2_) {
        return p_getRandomIntegerInRange_1_ >= p_getRandomIntegerInRange_2_ ? p_getRandomIntegerInRange_1_ : p_getRandomIntegerInRange_0_.nextInt(p_getRandomIntegerInRange_2_ - p_getRandomIntegerInRange_1_ + 1) + p_getRandomIntegerInRange_1_;
    }

    public static float randomFloatClamp(Random p_randomFloatClamp_0_, float p_randomFloatClamp_1_, float p_randomFloatClamp_2_) {
        return p_randomFloatClamp_1_ >= p_randomFloatClamp_2_ ? p_randomFloatClamp_1_ : p_randomFloatClamp_0_.nextFloat() * (p_randomFloatClamp_2_ - p_randomFloatClamp_1_) + p_randomFloatClamp_1_;
    }

    public static double getRandomDoubleInRange(Random p_getRandomDoubleInRange_0_, double p_getRandomDoubleInRange_1_, double p_getRandomDoubleInRange_3_) {
        return p_getRandomDoubleInRange_1_ >= p_getRandomDoubleInRange_3_ ? p_getRandomDoubleInRange_1_ : p_getRandomDoubleInRange_0_.nextDouble() * (p_getRandomDoubleInRange_3_ - p_getRandomDoubleInRange_1_) + p_getRandomDoubleInRange_1_;
    }

    public static double average(long[] p_average_0_) {
        long lvt_1_1_ = 0L;
        long[] lvt_3_1_ = p_average_0_;
        int lvt_4_1_ = p_average_0_.length;

        for(int lvt_5_1_ = 0; lvt_5_1_ < lvt_4_1_; ++lvt_5_1_) {
            long lvt_6_1_ = lvt_3_1_[lvt_5_1_];
            lvt_1_1_ += lvt_6_1_;
        }

        return (double)lvt_1_1_ / (double)p_average_0_.length;
    }


    public static boolean epsilonEquals(float p_epsilonEquals_0_, float p_epsilonEquals_1_) {
        return abs(p_epsilonEquals_1_ - p_epsilonEquals_0_) < 1.0E-5F;
    }


    public static int normalizeAngle(int p_normalizeAngle_0_, int p_normalizeAngle_1_) {
        return (p_normalizeAngle_0_ % p_normalizeAngle_1_ + p_normalizeAngle_1_) % p_normalizeAngle_1_;
    }

    public static float wrapAngleTo180_float(float p_wrapAngleTo180_float_0_) {
        p_wrapAngleTo180_float_0_ %= 360.0F;
        if (p_wrapAngleTo180_float_0_ >= 180.0F) {
            p_wrapAngleTo180_float_0_ -= 360.0F;
        }

        if (p_wrapAngleTo180_float_0_ < -180.0F) {
            p_wrapAngleTo180_float_0_ += 360.0F;
        }

        return p_wrapAngleTo180_float_0_;
    }

    public static double wrapAngleTo180_double(double p_wrapAngleTo180_double_0_) {
        p_wrapAngleTo180_double_0_ %= 360.0D;
        if (p_wrapAngleTo180_double_0_ >= 180.0D) {
            p_wrapAngleTo180_double_0_ -= 360.0D;
        }

        if (p_wrapAngleTo180_double_0_ < -180.0D) {
            p_wrapAngleTo180_double_0_ += 360.0D;
        }

        return p_wrapAngleTo180_double_0_;
    }

    public static int parseIntWithDefault(String p_parseIntWithDefault_0_, int p_parseIntWithDefault_1_) {
        try {
            return Integer.parseInt(p_parseIntWithDefault_0_);
        } catch (Throwable var3) {
            return p_parseIntWithDefault_1_;
        }
    }

    public static int parseIntWithDefaultAndMax(String p_parseIntWithDefaultAndMax_0_, int p_parseIntWithDefaultAndMax_1_, int p_parseIntWithDefaultAndMax_2_) {
        return Math.max(p_parseIntWithDefaultAndMax_2_, parseIntWithDefault(p_parseIntWithDefaultAndMax_0_, p_parseIntWithDefaultAndMax_1_));
    }

    public static double parseDoubleWithDefault(String p_parseDoubleWithDefault_0_, double p_parseDoubleWithDefault_1_) {
        try {
            return Double.parseDouble(p_parseDoubleWithDefault_0_);
        } catch (Throwable var4) {
            return p_parseDoubleWithDefault_1_;
        }
    }

    public static double parseDoubleWithDefaultAndMax(String p_parseDoubleWithDefaultAndMax_0_, double p_parseDoubleWithDefaultAndMax_1_, double p_parseDoubleWithDefaultAndMax_3_) {
        return Math.max(p_parseDoubleWithDefaultAndMax_3_, parseDoubleWithDefault(p_parseDoubleWithDefaultAndMax_0_, p_parseDoubleWithDefaultAndMax_1_));
    }

    public static int roundUpToPowerOfTwo(int p_roundUpToPowerOfTwo_0_) {
        int lvt_1_1_ = p_roundUpToPowerOfTwo_0_ - 1;
        lvt_1_1_ |= lvt_1_1_ >> 1;
        lvt_1_1_ |= lvt_1_1_ >> 2;
        lvt_1_1_ |= lvt_1_1_ >> 4;
        lvt_1_1_ |= lvt_1_1_ >> 8;
        lvt_1_1_ |= lvt_1_1_ >> 16;
        return lvt_1_1_ + 1;
    }

    private static boolean isPowerOfTwo(int p_isPowerOfTwo_0_) {
        return p_isPowerOfTwo_0_ != 0 && (p_isPowerOfTwo_0_ & p_isPowerOfTwo_0_ - 1) == 0;
    }

    private static int calculateLogBaseTwoDeBruijn(int p_calculateLogBaseTwoDeBruijn_0_) {
        p_calculateLogBaseTwoDeBruijn_0_ = isPowerOfTwo(p_calculateLogBaseTwoDeBruijn_0_) ? p_calculateLogBaseTwoDeBruijn_0_ : roundUpToPowerOfTwo(p_calculateLogBaseTwoDeBruijn_0_);
        return multiplyDeBruijnBitPosition[(int)((long)p_calculateLogBaseTwoDeBruijn_0_ * 125613361L >> 27) & 31];
    }

    public static int calculateLogBaseTwo(int p_calculateLogBaseTwo_0_) {
        return calculateLogBaseTwoDeBruijn(p_calculateLogBaseTwo_0_) - (isPowerOfTwo(p_calculateLogBaseTwo_0_) ? 0 : 1);
    }

    public static int roundUp(int p_roundUp_0_, int p_roundUp_1_) {
        if (p_roundUp_1_ == 0) {
            return 0;
        } else if (p_roundUp_0_ == 0) {
            return p_roundUp_1_;
        } else {
            if (p_roundUp_0_ < 0) {
                p_roundUp_1_ *= -1;
            }

            int lvt_2_1_ = p_roundUp_0_ % p_roundUp_1_;
            return lvt_2_1_ == 0 ? p_roundUp_0_ : p_roundUp_0_ + p_roundUp_1_ - lvt_2_1_;
        }
    }


    public static int func_180183_b(float p_180183_0_, float p_180183_1_, float p_180183_2_) {
        return func_180181_b(floor_float(p_180183_0_ * 255.0F), floor_float(p_180183_1_ * 255.0F), floor_float(p_180183_2_ * 255.0F));
    }


    public static int func_180181_b(int p_180181_0_, int p_180181_1_, int p_180181_2_) {
        int lvt_3_1_ = (p_180181_0_ << 8) + p_180181_1_;
        lvt_3_1_ = (lvt_3_1_ << 8) + p_180181_2_;
        return lvt_3_1_;
    }


    public static int func_180188_d(int p_180188_0_, int p_180188_1_) {
        int lvt_2_1_ = (p_180188_0_ & 16711680) >> 16;
        int lvt_3_1_ = (p_180188_1_ & 16711680) >> 16;
        int lvt_4_1_ = (p_180188_0_ & '\uff00') >> 8;
        int lvt_5_1_ = (p_180188_1_ & '\uff00') >> 8;
        int lvt_6_1_ = (p_180188_0_ & 255) >> 0;
        int lvt_7_1_ = (p_180188_1_ & 255) >> 0;
        int lvt_8_1_ = (int)((float)lvt_2_1_ * (float)lvt_3_1_ / 255.0F);
        int lvt_9_1_ = (int)((float)lvt_4_1_ * (float)lvt_5_1_ / 255.0F);
        int lvt_10_1_ = (int)((float)lvt_6_1_ * (float)lvt_7_1_ / 255.0F);
        return p_180188_0_ & -16777216 | lvt_8_1_ << 16 | lvt_9_1_ << 8 | lvt_10_1_;
    }


    public static double func_181162_h(double p_181162_0_) {
        return p_181162_0_ - Math.floor(p_181162_0_);
    }


    public static long getPositionRandom(Vec3i p_getPositionRandom_0_) {
        return getCoordinateRandom(p_getPositionRandom_0_.getX(), p_getPositionRandom_0_.getY(), p_getPositionRandom_0_.getZ());
    }

    public static UUID getRandomUuid(Random p_getRandomUuid_0_) {
        long lvt_1_1_ = p_getRandomUuid_0_.nextLong() & -61441L | 16384L;
        long lvt_3_1_ = p_getRandomUuid_0_.nextLong() & 4611686018427387903L | -9223372036854775808L;
        return new UUID(lvt_1_1_, lvt_3_1_);
    }


    public static long getCoordinateRandom(int p_getCoordinateRandom_0_, int p_getCoordinateRandom_1_, int p_getCoordinateRandom_2_) {
        long lvt_3_1_ = (long)(p_getCoordinateRandom_0_ * 3129871) ^ (long)p_getCoordinateRandom_2_ * 116129781L ^ (long)p_getCoordinateRandom_1_;
        lvt_3_1_ = lvt_3_1_ * lvt_3_1_ * 42317861L + lvt_3_1_ * 11L;
        return lvt_3_1_;
    }

    public static double func_181160_c(double p_181160_0_, double p_181160_2_, double p_181160_4_) {
        return (p_181160_0_ - p_181160_2_) / (p_181160_4_ - p_181160_2_);
    }

    public static double atan2(double p_atan2_0_, double p_atan2_2_) {
        double lvt_4_1_ = p_atan2_2_ * p_atan2_2_ + p_atan2_0_ * p_atan2_0_;
        if (Double.isNaN(lvt_4_1_)) {
            return 0.0D / 0.0;
        } else {
            boolean lvt_6_1_ = p_atan2_0_ < 0.0D;
            if (lvt_6_1_) {
                p_atan2_0_ = -p_atan2_0_;
            }

            boolean lvt_7_1_ = p_atan2_2_ < 0.0D;
            if (lvt_7_1_) {
                p_atan2_2_ = -p_atan2_2_;
            }

            boolean lvt_8_1_ = p_atan2_0_ > p_atan2_2_;
            double lvt_9_2_;
            if (lvt_8_1_) {
                lvt_9_2_ = p_atan2_2_;
                p_atan2_2_ = p_atan2_0_;
                p_atan2_0_ = lvt_9_2_;
            }

            lvt_9_2_ = func_181161_i(lvt_4_1_);
            p_atan2_2_ *= lvt_9_2_;
            p_atan2_0_ *= lvt_9_2_;
            double lvt_11_1_ = field_181163_d + p_atan2_0_;
            int lvt_13_1_ = (int)Double.doubleToRawLongBits(lvt_11_1_);
            double lvt_14_1_ = field_181164_e[lvt_13_1_];
            double lvt_16_1_ = field_181165_f[lvt_13_1_];
            double lvt_18_1_ = lvt_11_1_ - field_181163_d;
            double lvt_20_1_ = p_atan2_0_ * lvt_16_1_ - p_atan2_2_ * lvt_18_1_;
            double lvt_22_1_ = (6.0D + lvt_20_1_ * lvt_20_1_) * lvt_20_1_ * 0.16666666666666666D;
            double lvt_24_1_ = lvt_14_1_ + lvt_22_1_;
            if (lvt_8_1_) {
                lvt_24_1_ = 1.5707963267948966D - lvt_24_1_;
            }

            if (lvt_7_1_) {
                lvt_24_1_ = 3.141592653589793D - lvt_24_1_;
            }

            if (lvt_6_1_) {
                lvt_24_1_ = -lvt_24_1_;
            }

            return lvt_24_1_;
        }
    }

    public static double func_181161_i(double p_181161_0_) {
        double lvt_2_1_ = 0.5D * p_181161_0_;
        long lvt_4_1_ = Double.doubleToRawLongBits(p_181161_0_);
        lvt_4_1_ = 6910469410427058090L - (lvt_4_1_ >> 1);
        p_181161_0_ = Double.longBitsToDouble(lvt_4_1_);
        p_181161_0_ *= 1.5D - lvt_2_1_ * p_181161_0_ * p_181161_0_;
        return p_181161_0_;
    }


    public static int hsvToRGB(float p_hsvToRGB_0_, float p_hsvToRGB_1_, float p_hsvToRGB_2_) {
        int lvt_3_1_ = (int)(p_hsvToRGB_0_ * 6.0F) % 6;
        float lvt_4_1_ = p_hsvToRGB_0_ * 6.0F - (float)lvt_3_1_;
        float lvt_5_1_ = p_hsvToRGB_2_ * (1.0F - p_hsvToRGB_1_);
        float lvt_6_1_ = p_hsvToRGB_2_ * (1.0F - lvt_4_1_ * p_hsvToRGB_1_);
        float lvt_7_1_ = p_hsvToRGB_2_ * (1.0F - (1.0F - lvt_4_1_) * p_hsvToRGB_1_);
        float lvt_8_7_;
        float lvt_9_7_;
        float lvt_10_7_;
        switch(lvt_3_1_) {
            case 0:
                lvt_8_7_ = p_hsvToRGB_2_;
                lvt_9_7_ = lvt_7_1_;
                lvt_10_7_ = lvt_5_1_;
                break;
            case 1:
                lvt_8_7_ = lvt_6_1_;
                lvt_9_7_ = p_hsvToRGB_2_;
                lvt_10_7_ = lvt_5_1_;
                break;
            case 2:
                lvt_8_7_ = lvt_5_1_;
                lvt_9_7_ = p_hsvToRGB_2_;
                lvt_10_7_ = lvt_7_1_;
                break;
            case 3:
                lvt_8_7_ = lvt_5_1_;
                lvt_9_7_ = lvt_6_1_;
                lvt_10_7_ = p_hsvToRGB_2_;
                break;
            case 4:
                lvt_8_7_ = lvt_7_1_;
                lvt_9_7_ = lvt_5_1_;
                lvt_10_7_ = p_hsvToRGB_2_;
                break;
            case 5:
                lvt_8_7_ = p_hsvToRGB_2_;
                lvt_9_7_ = lvt_5_1_;
                lvt_10_7_ = lvt_6_1_;
                break;
            default:
                throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " + p_hsvToRGB_0_ + ", " + p_hsvToRGB_1_ + ", " + p_hsvToRGB_2_);
        }

        int lvt_11_1_ = clamp_int((int)(lvt_8_7_ * 255.0F), 0, 255);
        int lvt_12_1_ = clamp_int((int)(lvt_9_7_ * 255.0F), 0, 255);
        int lvt_13_1_ = clamp_int((int)(lvt_10_7_ * 255.0F), 0, 255);
        return lvt_11_1_ << 16 | lvt_12_1_ << 8 | lvt_13_1_;
    }

    static {
        int lvt_0_2_;
        for(lvt_0_2_ = 0; lvt_0_2_ < 65536; ++lvt_0_2_) {
            SIN_TABLE[lvt_0_2_] = (float)Math.sin((double)lvt_0_2_ * 3.141592653589793D * 2.0D / 65536.0D);
        }

        multiplyDeBruijnBitPosition = new int[]{0, 1, 28, 2, 29, 14, 24, 3, 30, 22, 20, 15, 25, 17, 4, 8, 31, 27, 13, 23, 21, 19, 16, 7, 26, 12, 18, 6, 11, 5, 10, 9};
        field_181163_d = Double.longBitsToDouble(4805340802404319232L);
        field_181164_e = new double[257];
        field_181165_f = new double[257];

        for(lvt_0_2_ = 0; lvt_0_2_ < 257; ++lvt_0_2_) {
            double lvt_1_1_ = (double)lvt_0_2_ / 256.0D;
            double lvt_3_1_ = Math.asin(lvt_1_1_);
            field_181165_f[lvt_0_2_] = Math.cos(lvt_3_1_);
            field_181164_e[lvt_0_2_] = lvt_3_1_;
        }

    }
}