// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Noise3D.java                                       :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: wto <marvin@42.fr>                         +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2018/11/22 22:43:40 by wto               #+#    #+#             //
//   Updated: 2018/11/22 22:43:40 by wto              ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

package avaj_launcher.util;

import java.util.Random;
import java.lang.Math;

public class Noise3D
{
	public static class Float3D
	{
		protected float x, y, z;

		public Float3D(float x, float y, float z)
		{
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	private static Random random = new Random();

	private static Float3D grad(int x, int y, int z)
	{
		random.setSeed(x * y * z);
		float xf = -1.0f + random.nextFloat() * 2;
		float yf = -1.0f + random.nextFloat() * 2;
		float zf = -1.0f + random.nextFloat() * 2;
		return new Float3D(xf, yf, zf);
	}

	private static float dotGrad(int x, int y, int z)
	{
		Float3D g = grad(x, y, z);
		return Math.abs(g.x + g.y + g.z) / 3.0f;
	}

	public static float get(int x, int y, int z)
	{
		float aaa = dotGrad(x, y, z);
		float baa = dotGrad(x + 1, y, z);
		float aba = dotGrad(x, y + 1, z);
		float bba = dotGrad(x + 1, y + 1, z);
		float aab = dotGrad(x, y, z + 1);
		float bab = dotGrad(x + 1, y, z + 1);
		float abb = dotGrad(x, y + 1, z + 1);
		float bbb = dotGrad(x + 1, y + 1, z + 1);

		float y1 = (aaa + baa + aba + bba) / 4.0f;
		float y2 = (aab + bab + abb + bbb) / 4.0f;
		return (y1 + y2) / 2.0f;
		
	}

}