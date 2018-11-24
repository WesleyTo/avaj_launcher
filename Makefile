#******************************************************************************#
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: wto <marvin@42.fr>                         +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2018/10/20 21:18:07 by wto               #+#    #+#              #
#    Updated: 2018/10/20 21:18:08 by wto              ###   ########.fr        #
#                                                                              #
#******************************************************************************#

NAME		=	avaj_launcher.simulator.Simulator
OUTDIR		=	./avaj_launcher

RM			=	/bin/rm
JAVA		=	java
COMPILER	=	javac

FLAGS		=	-d . -sourcepath
RMFLAGS		=	-rf

SRCFILE		=	sources.txt
OUTPUT		=	simulation.txt
SCENARIO	=	scenario.txt

ifndef VERBOSE
.SILENT:
endif

all: source
	$(COMPILER) $(FLAGS) @$(SRCFILE)

source:
	echo SOURCES > sources.txt
	find . -name *.java >> $(SRCFILE)

clean:
	$(RM) $(RMFLAGS) $(SRCFILE) $(OUTPUT)

fclean: clean
	$(RM) $(RMFLAGS) $(OUTDIR)

run:
	$(JAVA) $(NAME) $(SCENARIO)

re: fclean all
